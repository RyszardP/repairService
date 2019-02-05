package com.htp.repairService.domain.to;

public class Workshop extends Sector {

    private int workshop_id;
    private String workshop_title;
    private int workshop_master_id;

    public Workshop(int workshop_id, String workshop_title, int workshop_master_id) {
        this.workshop_id = workshop_id;
        this.workshop_title = workshop_title;
        this.workshop_master_id = workshop_master_id;
    }

    public Workshop(int sector_id, int master_id, String sectorTitle, int sector_owner, int workshop_id, String workshop_title, int workshop_master_id) {
        super(sector_id, master_id, sectorTitle, sector_owner);
        this.workshop_id = workshop_id;
        this.workshop_title = workshop_title;
        this.workshop_master_id = workshop_master_id;
    }

    public Workshop() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Workshop workshop = (Workshop) o;

        if (workshop_id != workshop.workshop_id) return false;
        if (workshop_master_id != workshop.workshop_master_id) return false;
        return workshop_title != null ? workshop_title.equals(workshop.workshop_title) : workshop.workshop_title == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + workshop_id;
        result = 31 * result + (workshop_title != null ? workshop_title.hashCode() : 0);
        result = 31 * result + workshop_master_id;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Workshop{");
        sb.append("workshop_id=").append(workshop_id);
        sb.append(", workshop_title='").append(workshop_title).append('\'');
        sb.append(", workshop_master_id=").append(workshop_master_id);
        sb.append('}');
        return sb.toString();
    }

    public int getWorkshop_id() {
        return workshop_id;
    }

    public void setWorkshop_id(int workshop_id) {
        this.workshop_id = workshop_id;
    }

    public String getWorkshop_title() {
        return workshop_title;
    }

    public void setWorkshop_title(String workshop_title) {
        this.workshop_title = workshop_title;
    }

    public int getWorkshop_master_id() {
        return workshop_master_id;
    }

    public void setWorkshop_master_id(int workshop_master_id) {
        this.workshop_master_id = workshop_master_id;
    }
}
