package domain.to;

import domain.enums.SectorTitle;

public class Sector {
    private int sector_id;
    private int master_id;
    private String sectorTitle;
    private int sector_owner;

    public Sector() {
    }

    public Sector(int sector_id, int master_id, String sectorTitle, int sector_owner) {
        this.sector_id = sector_id;
        this.master_id = master_id;
        this.sectorTitle = sectorTitle;
        this.sector_owner = sector_owner;
    }

    public int getSector_id() {
        return sector_id;
    }

    public void setSector_id(int sector_id) {
        this.sector_id = sector_id;
    }

    public int getMaster_id() {
        return master_id;
    }

    public void setMaster_id(int master_id) {
        this.master_id = master_id;
    }

    public String getSectorTitle() {
        return sectorTitle;
    }

    public void setSectorTitle(String sectorTitle) {
        this.sectorTitle = sectorTitle;
    }

    public int getSector_owner() {
        return sector_owner;
    }

    public void setSector_owner(int sector_owner) {
        this.sector_owner = sector_owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sector sector = (Sector) o;

        if (sector_id != sector.sector_id) return false;
        if (master_id != sector.master_id) return false;
        if (sector_owner != sector.sector_owner) return false;
        return sectorTitle != null ? sectorTitle.equals(sector.sectorTitle) : sector.sectorTitle == null;
    }

    @Override
    public int hashCode() {
        int result = sector_id;
        result = 31 * result + master_id;
        result = 31 * result + (sectorTitle != null ? sectorTitle.hashCode() : 0);
        result = 31 * result + sector_owner;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sector{");
        sb.append("sector_id=").append(sector_id);
        sb.append(", master_id=").append(master_id);
        sb.append(", sectorTitle='").append(sectorTitle).append('\'');
        sb.append(", sector_owner=").append(sector_owner);
        sb.append('}');
        return sb.toString();
    }
}
