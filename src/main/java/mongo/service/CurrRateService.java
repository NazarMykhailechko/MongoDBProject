package mongo.service;

import mongo.model.CurrRate;

import java.util.Collection;
import java.util.Currency;
import java.util.List;
import java.util.Optional;

public interface CurrRateService {

    void add (CurrRate currRate);
    void addAll (List<CurrRate> currRateList);
    Optional<CurrRate> findById(int id);
    Collection<CurrRate> getAllEmployees();
    void delete(int id);
    void deleteAll();
    List<CurrRate> showAll();

}
