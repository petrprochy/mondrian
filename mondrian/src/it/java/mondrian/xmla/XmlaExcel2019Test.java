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

public class XmlaExcel2019Test extends XmlaBaseTestCase {
    public XmlaExcel2019Test() {
    }

    public XmlaExcel2019Test(String name) {
        super(name);
    }

    @Override
    protected DiffRepository getDiffRepos() {
        return DiffRepository.lookup(XmlaExcel2019Test.class);
    }

    @Override
    protected Class<? extends XmlaRequestCallback> getServletCallbackClass() {
        return Callback.class;
    }

    @Override
    protected String getSessionId(Action action) {
        return getSessionId(XmlaExcel2019Test.class.getSimpleName(), action);
    }

    static class Callback extends XmlaRequestCallbackImpl {
        public Callback() {
            super(XmlaExcel2019Test.class.getSimpleName());
        }
    }

    public void test00DISCOVER_PROPERTIES() {
        helperTest(false);
    }

    public void test01DISCOVER_PROPERTIES() {
        helperTest(true);
    }
}
