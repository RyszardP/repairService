package domain.to;

public class Brigade {
    private int brigadeId;
    private String brigadeSpeciality;

    public Brigade() {
    }

    public Brigade(int brigadeId, String brigadeSpeciality) {
        this.brigadeId = brigadeId;
        this.brigadeSpeciality = brigadeSpeciality;
    }

    public int getBrigadeId() {
        return brigadeId;
    }

    public void setBrigadeId(int brigadeId) {
        this.brigadeId = brigadeId;
    }

    public String getBrigadeSpeciality() {
        return brigadeSpeciality;
    }

    public void setBrigadeSpeciality(String brigadeSpeciality) {
        this.brigadeSpeciality = brigadeSpeciality;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Brigade{");
        sb.append("brigadeId=").append(brigadeId);
        sb.append(", brigadeSpeciality='").append(brigadeSpeciality).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brigade brigade = (Brigade) o;

        if (brigadeId != brigade.brigadeId) return false;
        return brigadeSpeciality.equals(brigade.brigadeSpeciality);
    }

    @Override
    public int hashCode() {
        int result = brigadeId;
        result = 31 * result + brigadeSpeciality.hashCode();
        return result;
    }


}
