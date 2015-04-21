package org.propertymanager.code.client.presenter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.propertymanager.code.client.PropertyManagerServiceAsync;
import org.propertymanager.code.client.util.PropertyManagerConstants;
import org.propertymanager.code.entity.Request;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class AddMaintenanceRequestPresenter implements Presenter {
	private static Logger logger = Logger.getLogger("ParentLogger.Child");
	List<Request> requests;

	public interface Display {
		HasClickHandlers getAddButton();

		HasClickHandlers getSaveButton();

		HasClickHandlers getRequests();

		Widget asWidget();

		void addRow();

		List<Map<String, String>> saveRows();
	}

	private final Display display;
	private final HandlerManager eventBus;
	private final PropertyManagerServiceAsync rpcService;

	public AddMaintenanceRequestPresenter(PropertyManagerServiceAsync rpcServiceAsync,
			HandlerManager eventBus, Display view) {
		this.rpcService = rpcServiceAsync;
		this.eventBus = eventBus;
		this.display = view;
	}

	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		bind();
		container.clear();
		container.add(display.asWidget());

	}

	public void bind() {

		display.getAddButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				display.addRow();
			}
		});

		display.getSaveButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				List<Map<String, String>> requestScreen = display.saveRows();

				requests = createRequestVO(requestScreen);
				rpcService.saveResults(requests, new AsyncCallback<Long>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("Save Failed!!");
						logger.log(Level.SEVERE,"Save failed",caught);
					}

					@Override
					public void onSuccess(Long result) {
						// TODO Auto-generated method stub
						logger.log(Level.INFO, "savedddddd:"+result);
						if (result > 0) {
							Window.alert("Saved!!");
							eventBus.fireEvent(new SaveMaintenanceRequestEvent());
						}
					}
				});
	
			}
		});
	}

	protected List<Request> createRequestVO(
			List<Map<String, String>> requestScreen) {
		// TODO Auto-generated method stub
		if (requestScreen != null && requestScreen.size() > 0) {
			requests = new ArrayList<Request>(requestScreen.size());
			Request eachRequest = null;
			for (Map<String, String> row : requestScreen) {
				logger.log(Level.INFO, row.get(PropertyManagerConstants.DATE));
				eachRequest = new Request(Long.parseLong(row
						.get(PropertyManagerConstants.PROPERTYID)),	null, new Date(), row.get(PropertyManagerConstants.DESCRIPTION));
				requests.add(eachRequest);
			}
		}

		return requests;
	}

}