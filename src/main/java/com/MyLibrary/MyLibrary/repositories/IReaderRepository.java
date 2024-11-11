package com.MyLibrary.MyLibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MyLibrary.MyLibrary.models.ReaderModel;

@Repository
public interface IReaderRepository extends JpaRepository<ReaderModel, Integer> {

}
