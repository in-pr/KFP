package ee.ut.math.tvt.kungfupandas;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Intro {

	public static void main(String[] args) {
		Properties application = getParams("application");
		Properties version = getParams("version");
		new IntroUI(application, version.getProperty("build.major.number")
				+ "." + version.getProperty("build.minor.number") + "."
				+ version.getProperty("build.revision.number"));
	}

	private static Properties getParams(String filename) {
		Properties params = new Properties();
		try {
			//params.load(Intro.class.getClassLoader().getResourceAsStream(
					//filename + ".properties"));
			params.load(new FileInputStream(filename + ".properties"));
		} catch (IOException e) {
			// fails quietly and returns empty properties stack
		}
		return params;
	}

}
