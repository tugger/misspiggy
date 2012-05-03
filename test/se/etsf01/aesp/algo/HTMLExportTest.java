/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.etsf01.aesp.algo;

import org.junit.Test;
import se.etsf01.aesp.ExportHTML;

/**
 *
 * @author marcus
 */
public class HTMLExportTest {
    @Test
    public void testExport() {
        ExportHTML html = new ExportHTML("test.html", null, null);
        html.export();
    }
}
