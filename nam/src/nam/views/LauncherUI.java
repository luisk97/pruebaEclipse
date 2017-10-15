package nam.views;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTabGroup;

public class LauncherUI implements ILaunchConfigurationTabGroup{ 
	private ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[3];

	public LauncherUI(){ 
		tabs[0] = new org.eclipse.jdt.debug.ui.launchConfigurations.JavaMainTab();
		tabs[1] = new org.eclipse.jdt.debug.ui.launchConfigurations.JavaJRETab(); 
		tabs[2] = new org.eclipse.debug.ui.CommonTab(); 
	}

	@Override 
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) { 
		dialog.setActiveTab(tabs[0]);
	}

	@Override 
	public void dispose() {
	
	}

	@Override 
	public ILaunchConfigurationTab[] getTabs() {
		return tabs; 
	}
	
	@Override 
	public void initializeFrom(ILaunchConfiguration configuration) { 
		tabs[0].initializeFrom(configuration);
		tabs[1].initializeFrom(configuration); 
		tabs[2].initializeFrom(configuration); 
	}  
	
	@Override 
	public void launched(ILaunch launch) {
		
	}
	
	@Override 
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		tabs[0].performApply(configuration); 
		tabs[1].performApply(configuration); 
		tabs[2].performApply(configuration); 
	}
	
	@Override 
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		tabs[0].setDefaults(configuration); 
		tabs[1].setDefaults(configuration); 
		tabs[2].setDefaults(configuration); 
	}
}

