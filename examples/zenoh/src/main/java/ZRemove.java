/*
 * Copyright (c) 2017, 2020 ADLINK Technology Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
 *
 * Contributors:
 *   ADLINK zenoh team, <zenoh@adlink-labs.tech>
 */

import org.eclipse.zenoh.*;

public class ZRemove {

    public static void main(String[] args) {
        
        String path = "/zenoh/examples/java/put/hello";        
        String locator = null;

        if (args.length > 0 && (args[0].equals("-h") || args[0].equals("--help"))) {
            System.out.println("USAGE:\n\t ZRemove  [<path> = " + path + " [<locator>=auto]\n\n");
            System.exit(0);
        }
        if (args.length > 0) {
            path = args[0];
        }        
        if (args.length > 1) {
            locator = args[1];
        }

        try {
            Path p = new Path(path);

            System.out.println("Login to Zenoh (locator=" + locator + ")...");
            Zenoh z = Zenoh.login(locator, null);

            Workspace w = z.workspace();

            System.out.println("Remove " + p);
            w.remove(p);

            z.logout();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}