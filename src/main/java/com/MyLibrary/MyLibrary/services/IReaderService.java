package com.MyLibrary.MyLibrary.services;

import com.MyLibrary.MyLibrary.DTOs.ReaderModelDTO;
import com.MyLibrary.MyLibrary.DTOs.IU.ReaderModelIU;

import java.util.List;

public interface IReaderService {
    ReaderModelDTO getReaderById(Integer id);
    ReaderModelDTO getReaderByName(String name);
    List<ReaderModelDTO> getAllReaders();
    ReaderModelDTO deleteReader(ReaderModelIU reader);
    ReaderModelDTO existsReader(ReaderModelIU reader);
    ReaderModelDTO updateReader(ReaderModelIU reader);
    ReaderModelDTO saveReader(ReaderModelIU reader);
}
