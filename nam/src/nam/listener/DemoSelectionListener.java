package nam.listener;

import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.editors.text.TextEditor;

import nam.views.SampleView;

public class DemoSelectionListener implements ISelectionListener{

	private static DemoSelectionListener listener;
	
	public static DemoSelectionListener getListener(){ 
		if(listener==null) listener = new DemoSelectionListener(); 
		return listener; 
	}
	private DemoSelectionListener(){
		
	}
	public void selectionChanged(IWorkbenchPart part, ISelection selection) { 
		if(part instanceof TextEditor){ 
			TextSelection tselection = (TextSelection)selection; 
			SampleView.setArguments(tselection.getText()); 
		}
	}
}
