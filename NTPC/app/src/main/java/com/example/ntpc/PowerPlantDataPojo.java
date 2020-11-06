package com.example.ntpc;

import static java.lang.Math.abs;

public class PowerPlantDataPojo {

    private double FuelPrice;

    private double Dc;

    private double Sg;

    private double Ag;

    private double Frequency;

    private double DeviationRate;

    private double SgPlusOne;

    private double SgPlusTwo;

    private double SgPlusThree;

    private double SgPlusFour;

    private double Deviation_Rs;

    private double AdditionalDeviationCharge;

    private double Deviation;

    private double FuelCost;

    private double NetGain;

    private double PreviousNetGain;

    private double PreviousAdditionalDeviationCharge;

    private double PreviousFrequency;

    private double PreviousSg;

    private double PreviousDeviationRate;

    private double PreviousDeviation;

    private double PreviousDc;

    private double PreviousBlockNumber;

    private double PreviousFuelCost;

    private double PreviousDeviationRupees;

    private String PreviousBlock;

    public PowerPlantDataPojo() {
    }

    public String  getFrequency() {
        return Double.toString(Frequency);
    }

    public String getAg() {
        return  Double.toString(Ag);
    }

    public String getFuelPrice() {
        return Double.toString(abs(FuelPrice));
    }

    public String getDc() {
        return Double.toString(Dc);
    }

    public String getSg() {
        return Double.toString(Sg);
    }

    public String getNetGain() {
        return Double.toString(abs(NetGain));
    }

    public String getDeviation() {
        return Double.toString(Deviation);
    }

    public String getFuelCost() {
        return Double.toString(abs(FuelCost));
    }

    public String getDeviation_Rs() {
        return Double.toString(abs(Deviation_Rs));
    }

    public String getSgPlusFour() {
        return Double.toString(SgPlusFour);
    }

    public String getSgPlusThree() {
        return Double.toString(SgPlusThree);
    }

    public String getSgPlusTwo() {
        return Double.toString(SgPlusTwo);
    }

    public String getSgPlusOne() {
        return Double.toString(SgPlusOne);
    }

    public String getDeviationRate() {
        return Double.toString(abs(DeviationRate));
    }

    public String getAdditionalDeviationCharge() {
        return Double.toString(abs(AdditionalDeviationCharge));
    }

    public String getPreviousNetGain() {
        return Double.toString(abs(PreviousNetGain));
    }

    public String getPreviousAdditionalDeviationCharge() {
        return Double.toString(abs(PreviousAdditionalDeviationCharge));
    }

    public String getPreviousFrequency() {
        return Double.toString(PreviousFrequency);
    }

    public String getPreviousDeviationRate() {
        return Double.toString(abs(PreviousDeviationRate));
    }

    public String getPreviousSg() {
        return Double.toString(PreviousSg);
    }


    public String getPreviousDeviation() {
        return Double.toString(abs(PreviousDeviation));
    }

    public String getPreviousDc() {
        return Double.toString(abs(PreviousDc));
    }

    public String getPreviousBlockNumber() {
        return Double.toString(PreviousBlockNumber);
    }

    public String getPreviousFuelCost() {
        return Double.toString(abs(PreviousFuelCost));
    }

    public String getPreviousDeviationRupees() {
        return Double.toString(abs(PreviousDeviationRupees));
    }

    public String getPreviousBlock() {
        return PreviousBlock;
    }
}
