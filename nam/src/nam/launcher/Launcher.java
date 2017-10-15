package nam.launcher;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jdt.launching.JavaLaunchDelegate;

import nam.views.SampleView;

public class Launcher extends JavaLaunchDelegate {
	
	public String getProgramArguments(ILaunchConfiguration configuration) throws 
		CoreException{
			return super.getProgramArguments(configuration) + " " + SampleView.getArguments().replace("\n", " ").replace("\r", " ");
	}

}
