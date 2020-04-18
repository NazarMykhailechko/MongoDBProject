package mongo.service;

import mongo.model.CurrRate;
import mongo.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CurrRatesServiceImpl implements CurrRateService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public void add(CurrRate currRate) {
        currencyRepository.save(currRate);
    }

    @Override
    public void addAll(List<CurrRate> currRateList) {
        currencyRepository.saveAll(currRateList);
    }

    @Override
    public Optional<CurrRate> findById(int id) {
        return currencyRepository.findById(id);
    }

    @Override
    public Collection<CurrRate> getAllEmployees() {
        return currencyRepository.findAll();
    }

    @Override
    public void delete(int id) {
        currencyRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        currencyRepository.deleteAll();
    }

    @Override
    public List<CurrRate> showAll() {
        return currencyRepository.findAll();
    }
}
