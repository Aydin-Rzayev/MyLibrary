package com.MyLibrary.MyLibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyLibrary.MyLibrary.models.ReaderModel;

public interface IReaderRepository extends JpaRepository<ReaderModel, Integer> {

}
