package by.epamtc.voloshchik.dao;

public class DAOException extends Exception{
    public DAOException() {
        super();
    }
    public DAOException(String msg) {
        super(msg);
    }
    public DAOException(String msg,Throwable cause) {
        super(msg,cause);
    }
}
