package com.example.demo.repo;

import com.example.demo.dto.ItemResponseDTO;
import com.example.demo.entity.Item;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {

    List<Item>findAllByItemNameAndActiveState(String itemName, boolean b);



    Page<Item> findAllByActiveStateEquals(boolean activeState, Pageable pageable);


    int countAllByActiveStateEquals(boolean activeState);

    List<Item> findAllByActiveStateEquals(boolean activeState);
}
