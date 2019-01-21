package domain.to;

import domain.enums.Gender;

import java.io.Serializable;

public class WorkerBrigade
    implements Serializable

    {
        private static final long serialVersionUID = 1L;

        private int worker_id;
        private String name;
        private String surname;
        private String email;
        private String login;
        private String password;
        private Gender gender;
        private String specialty;
        private String role;
        private int workerBrigade_id;


        public static long getSerialVersionUID() {
        return serialVersionUID;
    }

        public WorkerBrigade(int worker_id, String name, String surname, String email, String login, String password, Gender gender, String specialty, String role, int workerBrigade_id) {
            this.worker_id = worker_id;
            this.name = name;
            this.surname = surname;
            this.email = email;
            this.login = login;
            this.password = password;
            this.gender = gender;
            this.specialty = specialty;
            this.role = role;
            this.workerBrigade_id = workerBrigade_id;
        }

        public int getWorker_id() {
            return worker_id;
        }

        public void setWorker_id(int worker_id) {
            this.worker_id = worker_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public String getSpecialty() {
            return specialty;
        }

        public void setSpecialty(String specialty) {
            this.specialty = specialty;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public int getWorkerBrigade_id() {
            return workerBrigade_id;
        }

        public void setWorkerBrigade_id(int workerBrigade_id) {
            this.workerBrigade_id = workerBrigade_id;
        }

        public WorkerBrigade() {
    }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WorkerBrigade that = (WorkerBrigade) o;

            if (worker_id != that.worker_id) return false;
            if (workerBrigade_id != that.workerBrigade_id) return false;
            if (!name.equals(that.name)) return false;
            if (!surname.equals(that.surname)) return false;
            if (!email.equals(that.email)) return false;
            if (!login.equals(that.login)) return false;
            if (!password.equals(that.password)) return false;
            if (gender != that.gender) return false;
            if (!specialty.equals(that.specialty)) return false;
            return role.equals(that.role);
        }

        @Override
        public int hashCode() {
            int result = worker_id;
            result = 31 * result + name.hashCode();
            result = 31 * result + surname.hashCode();
            result = 31 * result + email.hashCode();
            result = 31 * result + login.hashCode();
            result = 31 * result + password.hashCode();
            result = 31 * result + gender.hashCode();
            result = 31 * result + specialty.hashCode();
            result = 31 * result + role.hashCode();
            result = 31 * result + workerBrigade_id;
            return result;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("WorkerBrigade{");
            sb.append("worker_id=").append(worker_id);
            sb.append(", name='").append(name).append('\'');
            sb.append(", surname='").append(surname).append('\'');
            sb.append(", email='").append(email).append('\'');
            sb.append(", login='").append(login).append('\'');
            sb.append(", password='").append(password).append('\'');
            sb.append(", gender=").append(gender);
            sb.append(", specialty='").append(specialty).append('\'');
            sb.append(", role='").append(role).append('\'');
            sb.append(", workerBrigade_id=").append(workerBrigade_id);
            sb.append('}');
            return sb.toString();
        }
    }


