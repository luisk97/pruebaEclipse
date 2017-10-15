package nam.views;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.part.ViewPart;

import nam.listener.DemoSelectionListener;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class SampleView extends ViewPart {
	private static SampleView view;
	private Text argumentsField;
	private static String arguments;
	
	public SampleView() {
		registerSelectionListener();
		view = this;
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		GridLayout gridLayout = new GridLayout(1, false);
		
		parent.setLayout(gridLayout);
		
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace =true;
		gridData.grabExcessVerticalSpace = true;
		
		Label label = new Label(parent, SWT.NULL);
		label.setText("Argumentos del Programa: ");
		
		argumentsField = new Text(parent, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		argumentsField.setLayoutData(gridData);
		argumentsField.setText("");
		argumentsField.addListener(SWT.CHANGED, new Listener() {
			@Override
			public void handleEvent(Event event) {
				setArguments(argumentsField.getText());
			}
		});
		
		parent.pack();
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

	public static void setArguments(final String arguments) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				view.argumentsField.setText(arguments);
			}
		});
		SampleView.arguments = arguments;
	}
	
	public static String getArguments() {
		return arguments;
	}
	
	private void registerSelectionListener() { 
		new Thread(new Runnable() { 
			@Override 
			public void run() { 
				IWorkbenchPartSite site = null;
				
				while (site == null) { 
					try { 
						Thread.sleep(50); 
					} catch (InterruptedException e) { 
						e.printStackTrace(); 
					} 
					site = getSite(); 
					} 
				IWorkbenchWindow window = site.getWorkbenchWindow(); 
				window.getSelectionService().addSelectionListener( DemoSelectionListener.getListener());
			} 
		}).start();
	}
	
	public void dispose(){ 
		getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(DemoSelectionListener.getListener());
		super.dispose(); 
	}

}
