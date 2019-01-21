package exception;

/**
 * Created by user on 15.01.2019.
 */

    public class DaoException extends Exception {

        private static final long serialVersionUID = 1L;

        public DaoException(String message){
            super(message);
        }

        public DaoException(String message, Exception ex){
            super(message, ex);
        }
    }

