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

import mondrian.olap.Util;
import mondrian.rolap.RolapConnectionProperties;
import mondrian.spi.impl.FilterDynamicSchemaProcessor;
import mondrian.test.DiffRepository;
import mondrian.test.TestContext;

import java.util.Locale;

/**
 * This test tests calling the olap4j driver with another locale than default.
 *
 * @author Petr Procházka (petrprochy)
 * @since 2025-02-25
 */
public class XmlaDynamicProcessorTest extends XmlaBaseTestCase {
    @Override
    protected DiffRepository getDiffRepos() {
        return DiffRepository.lookup(XmlaDynamicProcessorTest.class);
    }

    @Override
    protected Class<? extends XmlaRequestCallback> getServletCallbackClass() {
        return Callback.class;
    }

    @Override
    protected String getSessionId(Action action) {
        return getSessionId(XmlaDynamicProcessorTest.class.getSimpleName(), action);
    }

    @Override
    public TestContext getTestContext() {
        return super.getTestContext().withSchemaProcessor(TestLocaleProcessor.class);
    }

    static class Callback extends XmlaRequestCallbackImpl {
        Callback() {
            super(XmlaDynamicProcessorTest.class.getSimpleName());
        }
    }

    public void testNoLocale() {
        helperTest(true);
    }

    public void testENLocale() {
        helperTest(true);
    }

    public void testCSLocale() {
        helperTest(true);
    }


    public static class TestLocaleProcessor extends FilterDynamicSchemaProcessor {
        @Override
        public String processSchema(String schemaUrl, Util.PropertyList connectInfo) throws Exception {
            final String schema = super.processSchema(schemaUrl, connectInfo);
            return replace(schema, connectInfo);
        }

        @Override
        public String processCatalog(String catalog, Util.PropertyList connectInfo) throws Exception {
            return super.processCatalog(catalog, connectInfo);
        }

        private static String replace(String schema, Util.PropertyList connectInfo) {
            final String locale = connectInfo.get(RolapConnectionProperties.Locale.name(), Locale.getDefault().toString());
            return schema.replace("%{lang}", locale);
        }
    }
}
