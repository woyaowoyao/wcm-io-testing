/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2016 wcm.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.wcm.testing.mock.wcmio.caconfig;

import org.apache.sling.testing.mock.osgi.context.AbstractContextPlugin;
import org.apache.sling.testing.mock.osgi.context.ContextPlugin;

import io.wcm.caconfig.application.impl.ApplicationAdapterFactory;
import io.wcm.caconfig.application.impl.ApplicationFinderImpl;
import io.wcm.caconfig.application.impl.ApplicationImplementationPicker;
import io.wcm.testing.mock.aem.junit.AemContext;

/**
 * Mock context plugins.
 */
public final class ContextPlugins {

  private ContextPlugins() {
    // constants only
  }

  /**
   * Context plugin for wcm.io Context-Aware Configuration.
   */
  public static final ContextPlugin<AemContext> WCMIO_CACONFIG = new AbstractContextPlugin<AemContext>() {
    @Override
    public void afterSetUp(AemContext context) throws Exception {
      setUpCompat(context);
    }
  };

  /**
   * Set up all mandatory OSGi services for wcm.io Configuration support.
   * @param context Aem context
   */
  private static void setUpCompat(AemContext context) {

    // application detection
    context.registerInjectActivateService(new ApplicationFinderImpl());
    context.registerInjectActivateService(new ApplicationImplementationPicker());
    context.registerInjectActivateService(new ApplicationAdapterFactory());

  }

}
