/*******************************************************************************
 * Copyright (c) 2014, 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.injection.envann.web;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class AdvEnvAnnPrimHttpSessionListener implements HttpSessionListener {
    private static final String CLASS_NAME = AdvEnvAnnPrimServletRequestListener.class.getName();
    private final static Logger svLogger = Logger.getLogger(CLASS_NAME);

    // Resources to be injected
    @Resource
    private char ifchar;
    @Resource
    private byte ifbyte;
    @Resource
    private short ifshort;
    @Resource
    private int ifint;
    @Resource
    private long iflong;
    @Resource
    private boolean ifboolean;
    @Resource
    private double ifdouble;
    @Resource
    private float iffloat;

    // Resources to be injected
    private char imchar;
    private byte imbyte;
    private short imshort;
    private int imint;
    private long imlong;
    private boolean imboolean;
    private double imdouble;
    private float imfloat;

    private final String[] fieldNames = { "ifchar", "ifbyte", "ifshort", "ifint", "iflong", "ifboolean", "ifdouble", "iffloat" };
    private final String[] methodNames = { "imchar", "imbyte", "imshort", "imint", "imlong", "imboolean", "imdouble", "imfloat" };

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        svLogger.info("Prim Http Session: Session created...");
        processRequest(WCEventTracker.KEY_LISTENER_CREATED_AdvEnvAnnPrimHttpSessionListener);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // Do Nothing
    }

    public void processRequest(String key) {
        // Test Field injection
        EnvAnnPrimTestHelper.testEnvAnnPrimInjection(CLASS_NAME, key, ifchar, ifbyte, ifshort, ifint, iflong, ifboolean, ifdouble, iffloat, fieldNames);
        // Test Method Injection
        EnvAnnPrimTestHelper.testEnvAnnPrimInjection(CLASS_NAME, key, imchar, imbyte, imshort, imint, imlong, imboolean, imdouble, imfloat, methodNames);
    }

    @Resource
    public void setImchar(char imchar) {
        this.imchar = imchar;
    }

    @Resource
    public void setImbyte(byte imbyte) {
        this.imbyte = imbyte;
    }

    @Resource
    public void setImshort(short imshort) {
        this.imshort = imshort;
    }

    @Resource
    public void setImint(int imint) {
        this.imint = imint;
    }

    @Resource
    public void setImlong(long imlong) {
        this.imlong = imlong;
    }

    @Resource
    public void setImboolean(boolean imboolean) {
        this.imboolean = imboolean;
    }

    @Resource
    public void setImdouble(double imdouble) {
        this.imdouble = imdouble;
    }

    @Resource
    public void setImfloat(float imfloat) {
        this.imfloat = imfloat;
    }
}