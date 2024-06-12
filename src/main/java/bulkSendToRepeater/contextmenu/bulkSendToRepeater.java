/*
 * Copyright (c) 2023. PortSwigger Ltd. All rights reserved.
 *
 * This code may be used to extend the functionality of Burp Suite Community Edition
 * and Burp Suite Professional, provided that this usage does not violate the
 * license terms for those products.
 */

package bulkSendToRepeater.contextmenu;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;
import burp.api.montoya.logging.Logging;
import burp.api.montoya.extension.ExtensionUnloadingHandler;

public class bulkSendToRepeater implements BurpExtension
{
    private Logging logging;
    @Override
    public void initialize(MontoyaApi api)
    {
        api.extension().setName("Bulk Send to Repeater");
        logging = api.logging();
        api.userInterface().registerContextMenuItemsProvider(new MyContextMenuItemsProvider(api));

        api.extension().registerUnloadingHandler(new MyExtensionUnloadHandler());
    }
    private class MyExtensionUnloadHandler implements ExtensionUnloadingHandler {
		@Override
	public void extensionUnloaded() {
            //logging.logToOutput("Extension was unloaded.");
	}
    }
}
