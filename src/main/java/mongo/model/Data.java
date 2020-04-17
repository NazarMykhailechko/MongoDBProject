package mongo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("DT")
    @Expose
    public String dT;
    @SerializedName("CURR")
    @Expose
    public String cURR;
    @SerializedName("Counterpart")
    @Expose
    public String counterpart;
    @SerializedName("REST")
    @Expose
    public String rEST;
    @SerializedName("EQV")
    @Expose
    public String eQV;
    @SerializedName("AP")
    @Expose
    public String aP;
    @SerializedName("ID_DIV")
    @Expose
    public String iDDIV;
    @SerializedName("OKPO")
    @Expose
    public String oKPO;
    @SerializedName("DIV_NAME")
    @Expose
    public String dIVNAME;
    @SerializedName("ACC")
    @Expose
    public String aCC;
    @SerializedName("CUST_ID")
    @Expose
    public String cUSTID;

    @Override
    public String toString() {
        return "{" +
                "dT:'" + dT + '\'' +
                ", cURR:'" + cURR + '\'' +
                ", counterpart:'" + counterpart + '\'' +
                ", rEST:'" + rEST + '\'' +
                ", eQV:'" + eQV + '\'' +
                ", aP:'" + aP + '\'' +
                ", iDDIV:'" + iDDIV + '\'' +
                ", oKPO:'" + oKPO + '\'' +
                ", dIVNAME:'" + dIVNAME + '\'' +
                ", aCC:'" + aCC + '\'' +
                ", cUSTID:'" + cUSTID + '\'' +
                '}';
    }
}