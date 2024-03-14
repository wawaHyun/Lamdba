
package com.turing.api.common;

public interface UtilService {
    int createRandomInteger(int start,int andEnd);
    double createRandomDouble(double start, double andEnd);

    String createRandomName();
    String createRandomContents();
    String createRandomTitles();
    String createRandomMemberId();
    String createRandomAccount();
    String createRandomJob();
}