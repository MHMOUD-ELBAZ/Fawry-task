package Interfaces;

import java.time.LocalDate;
import java.util.Date;

public interface Expirable {
    LocalDate getExpirationDate();
    void setExpirationDate(LocalDate date);
}
