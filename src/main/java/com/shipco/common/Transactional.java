package com.shipco.common;

/**
 * At the beginning of an annotated method, starts a JDBC transaction.
 * If the method finishes without error, commits the transaction.
 * If the method throws an exception, rollback the transaction.
 */
public @interface Transactional {
}
