/*
 * Generated by XDoclet - Do not edit!
 */
package com.mockrunner.example.ejb.interfaces;

/**
 * Home interface for BillManagerSession.
 */
public interface BillManagerSessionHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/BillManagerSession";
   public static final String JNDI_NAME="com/mockrunner/example/BillManagerSession";

   public com.mockrunner.example.ejb.interfaces.BillManagerSession create()
      throws javax.ejb.CreateException,java.rmi.RemoteException;

}
