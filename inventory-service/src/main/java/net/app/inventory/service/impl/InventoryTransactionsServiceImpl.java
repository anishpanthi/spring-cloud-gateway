package net.app.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.app.inventory.dto.InventoryTransactionsDto;
import net.app.inventory.service.InventoryTransactionsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Anish Panthi
 */
@Service
@Log4j2
@RequiredArgsConstructor
public class InventoryTransactionsServiceImpl implements InventoryTransactionsService {
    @Override
    public Optional<InventoryTransactionsDto> findOne(Long aLong) {
    return Optional.empty();
    }

    @Override
    public List<InventoryTransactionsDto> findAll() {
        return List.of();
    }

    @Override
    public InventoryTransactionsDto create(InventoryTransactionsDto inventoryTransactionsDto) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public InventoryTransactionsDto update(InventoryTransactionsDto inventoryTransactionsDto) {
        return null;
    }

    @Override
    public Page<InventoryTransactionsDto> findAll(Pageable pageable) {
        return InventoryTransactionsService.super.findAll(pageable);
    }
}
