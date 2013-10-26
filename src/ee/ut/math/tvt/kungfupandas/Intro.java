package ee.ut.math.tvt.kungfupandas;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.controller.impl.SalesDomainControllerImpl;
import ee.ut.math.tvt.salessystem.ui.ConsoleUI;
import ee.ut.math.tvt.salessystem.ui.SalesSystemUI;

public class Intro {

	private static final Logger log = Logger.getLogger(Intro.class);
	private static final String MODE = "console";
	
	public static void main(String[] args) {
		final SalesDomainController domainController = new SalesDomainControllerImpl();

		if (args.length == 1 && args[0].equals(MODE)) {
			log.debug("Mode: " + MODE);

			ConsoleUI cui = new ConsoleUI(domainController);
			cui.run();
		} else {
			Properties application = getParams("application");
			Properties version = getParams("version");
			
			IntroUI introUI = new IntroUI(application,
					version.getProperty("build.major.number") + "."
							+ version.getProperty("build.minor.number") + "."
							+ version.getProperty("build.revision.number"));
			introUI.setVisible(true);
			introUI.setAlwaysOnTop(true);

			final SalesSystemUI ui = new SalesSystemUI(domainController);
			ui.setVisible(true);

			introUI.setAlwaysOnTop(false);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			introUI.setVisible(false);
		}
		
		/*
		Properties application = getParams("application");
		Properties version = getParams("version");
		IntroUI teaminfo = new IntroUI(application,
				version.getProperty("build.major.number") + "."
						+ version.getProperty("build.minor.number") + "."
						+ version.getProperty("build.revision.number"));
		teaminfo.setVisible(true);*/
	}

	private static Properties getParams(String filename) {
		Properties params = new Properties();
		try {
			try {
				params.load(Intro.class.getClassLoader().getResourceAsStream(
						filename + ".properties"));
			} catch (NullPointerException e) {
				// if file is inaccessible, try a direct stream
				params.load(new FileInputStream(filename + ".properties"));
			}
		} catch (IOException e) {
			// fails quietly and returns empty properties stack
		}
		return params;
	}

}
