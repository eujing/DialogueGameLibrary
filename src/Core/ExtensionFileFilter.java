package Core;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class ExtensionFileFilter extends FileFilter {
	
	private String[] fileExtensions;
	
	public ExtensionFileFilter (String[] fileExtensions) {
		this.fileExtensions = fileExtensions;
	}

	@Override
	public String getDescription () {
		String buffer = "";
		for (int i = 0; i < fileExtensions.length; i++) {
			if (i + 1 < fileExtensions.length) {
				buffer += fileExtensions[i] + ", ";
			}
			else {
				if (fileExtensions.length > 1) {
					buffer += "and ";
				}
				buffer += fileExtensions[i];
			}
		}

		return buffer;
	}

	@Override
	public boolean accept (File file) {
		if (file.isDirectory ()) {
			return true;
		}
		
		for (String extension : fileExtensions) {
			if (file.getName ().toLowerCase ().endsWith (extension)) {
				return true;
			}
		}

		return false;
	}
}
