/*
 // This software is subject to the terms of the Eclipse Public License v1.0
 // Agreement, available at the following URL:
 // http://www.eclipse.org/legal/epl-v10.html.
 // You must accept the terms of that agreement to use this software.
 //
 // Copyright (C) 2025 - 2025 Hitachi Vantara
 // All Rights Reserved.
 */
package mondrian.xmla;

import mondrian.test.DiffRepository;

/**
 * Test suite compatible with Excel 2013
 *
 * @author Petr Procházka (petrprochy)
 */
public class XmlaExcel2013Test extends XmlaBaseTestCase {
    public XmlaExcel2013Test() {
    }

    public XmlaExcel2013Test(String name) {
        super(name);
    }

    @Override
    protected DiffRepository getDiffRepos() {
        return DiffRepository.lookup(XmlaExcel2013Test.class);
    }

    @Override
    protected Class<? extends XmlaRequestCallback> getServletCallbackClass() {
        return Callback.class;
    }

    @Override
    protected String getSessionId(Action action) {
        return getSessionId(XmlaExcel2013Test.class.getSimpleName(), action);
    }

    static class Callback extends XmlaRequestCallbackImpl {
        Callback() {
            super(XmlaExcel2013Test.class.getSimpleName());
        }
    }


    public void test000PropertyDbpropMsmdSubqueries() {
        helperTest(false);
    }

    public void test001PropertyDbpropMsmdOptimizeResponse() {
        helperTest(false);
    }

    public void test002PropertyDbpropMsmdActivityID() {
        helperTest(false);
    }

    public void test003BeginSessionToken() {
        helperTest(false);
    }

    public void test004BeginSession() {
        helperTest(false);
    }

    public void test005PropertyCatalog() {
        helperTest(true);
    }

    public void test006PropertyServerName() {
        helperTest(true);
    }

    public void test007PropertyProviderVersion() {
        helperTest(true);
    }

    public void test008PropertyMdpropMdxDdlExtensions() {
        helperTest(true);
    }

    public void test009FoodMartPropertyMdpropMdxSubqueries() {
        helperTest(true);
    }

    public void test010FoodMartPropertyMdpropMdxDrillFunctions() {
        helperTest(true);
    }

    public void test011FoodMartPropertyMdpropMdxNamedSets() {
        helperTest(true);
    }

    public void test012FoodMartDISCOVER_SCHEMA_ROWSETS() {
        helperTest(true);
    }

    public void test013FoodMartDBSCHEMA_CATALOGS() {
        helperTest(true);
    }

    public void test014FoodMartMDSCHEMA_CUBES() {
        helperTest(true);
    }

    public void test015FoodMartDBSCHEMA_TABLES() {
        helperTest(true);
    }

    public void test016EndSession() {
        helperTest(true);
    }


    public void test129DISCOVER_SCHEMA_ROWSETS() {
        helperTest(true);
    }
}
