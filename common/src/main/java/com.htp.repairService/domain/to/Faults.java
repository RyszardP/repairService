package com.htp.repairService.domain.to;

import java.util.Date;

public class Faults {

    private int fault_id;
    private int sectorFault_id;
    private String fault_type;
    private Date date_in;
    private Date finish_date;

    public Faults() {
    }

    public int getFault_id() {
        return fault_id;
    }

    public void setFault_id(int fault_id) {
        this.fault_id = fault_id;
    }

    public int getSectorFault_id() {
        return sectorFault_id;
    }

    public void setSectorFault_id(int sectorFault_id) {
        this.sectorFault_id = sectorFault_id;
    }

    public String getFault_type() {
        return fault_type;
    }

    public void setFault_type(String fault_type) {
        this.fault_type = fault_type;
    }

    public Date getDate_in() {
        return date_in;
    }

    public void setDate_in(Date date_in) {
        this.date_in = date_in;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(Date finish_date) {
        this.finish_date = finish_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Faults faults = (Faults) o;

        if (fault_id != faults.fault_id) return false;
        if (sectorFault_id != faults.sectorFault_id) return false;
        if (!fault_type.equals(faults.fault_type)) return false;
        if (!date_in.equals(faults.date_in)) return false;
        return finish_date != null ? finish_date.equals(faults.finish_date) : faults.finish_date == null;
    }

    @Override
    public int hashCode() {
        int result = fault_id;
        result = 31 * result + sectorFault_id;
        result = 31 * result + fault_type.hashCode();
        result = 31 * result + date_in.hashCode();
        result = 31 * result + (finish_date != null ? finish_date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Faults{");
        sb.append("fault_id=").append(fault_id);
        sb.append(", sectorFault_id=").append(sectorFault_id);
        sb.append(", fault_type='").append(fault_type).append('\'');
        sb.append(", date_in=").append(date_in);
        sb.append(", finish_date=").append(finish_date);
        sb.append('}');
        return sb.toString();
    }
}
