package ua.kpi.training.controller;

/**
 * Created by Kirill on 03.05.2017.
 */
public interface RegExp {
    String NUMBER_OF_COMPOSITION = "^[1-2][0-9]|[1-9]$";
    String BREAK_DATE_BY_DOT = "[.]";
    String IDENTIFY_BUMDLE = "^([E|e][N|n])|[У|у][К|к][Р|р]$";
    String DURATION = "^[1-9]|[1-9][0-9]|[1-4][0-9][0-9]$";
}
