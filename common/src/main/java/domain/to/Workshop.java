package domain.to;

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
