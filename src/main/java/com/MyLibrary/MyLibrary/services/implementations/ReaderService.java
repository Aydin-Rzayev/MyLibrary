package com.MyLibrary.MyLibrary.services.implementations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.MyLibrary.MyLibrary.DTOs.ReaderModelDTO;
import com.MyLibrary.MyLibrary.DTOs.IU.ReaderModelIU;
import com.MyLibrary.MyLibrary.models.ReaderModel;
import com.MyLibrary.MyLibrary.repositories.IReaderRepository;

public class ReaderService {
    @Autowired
    private IReaderRepository readerRepository;
     public ReaderModelDTO saveReader(ReaderModelIU reader){
        ReaderModel readerModel = new ReaderModel();
        BeanUtils.copyProperties(reader, readerModel);
        ReaderModelDTO readerDto = new ReaderModelDTO();
        if(readerRepository.findByNameAndId(readerModel.getName(), readerModel.getId()).isPresent()){
            BeanUtils.copyProperties(readerRepository.save(readerModel), readerDto);
            return readerDto;
        }
        return null;
    }

    public ReaderModelDTO existsReader(ReaderModelIU reader){
        ReaderModel readerModel = new ReaderModel();
        BeanUtils.copyProperties(reader, readerModel);
        ReaderModelDTO response = new ReaderModelDTO();
        BeanUtils.copyProperties(readerRepository.findByNameAndId(readerModel.getName(), readerModel.getId()).orElse(null), response);
        return response;
    }

    public ReaderModelDTO getReaderByName(String name){
        Iterator<ReaderModel> readers = readerRepository.findAll().iterator();
        Optional<ReaderModelDTO> reader = Optional.of(new ReaderModelDTO());
        while(readers.hasNext()){
            ReaderModel next = readers.next();
            if(next.getName().equals(name)){
                BeanUtils.copyProperties(next, reader.get());
            }
        }
        return reader.orElse(null);
    }

    public ReaderModelDTO getReaderById(Integer id){
        Optional<ReaderModel> readerOptional = readerRepository.findById(id);
        ReaderModelDTO reader = new ReaderModelDTO();
        BeanUtils.copyProperties(readerOptional.orElse(null), reader);
        return reader;
    }

    public List<ReaderModelDTO> getAllReaders(){
        List<ReaderModelDTO> readers = new ArrayList<>();
        Iterator<ReaderModel> readerModel = readerRepository.findAll().iterator();
        while(readerModel.hasNext()){
            ReaderModel read = readerModel.next();
            ReaderModelDTO authDTO = new ReaderModelDTO();
            BeanUtils.copyProperties(read, authDTO);
            readers.add(authDTO);
        }
        return readers;
    }

    public ReaderModelDTO updateReader(Integer id, String param, String val){
        Optional<ReaderModel> readerOptional = readerRepository.findById(id);
        if (readerOptional.isPresent()) {
            ReaderModel readerModel = readerOptional.get();
            switch(param) {
                case "name":
                    readerModel.setName(val);
                    readerRepository.save(readerModel);
                    break;
                case "email":
                    readerModel.setEmail(val);
                    readerRepository.save(readerModel);
                default:
                    break;
        }
            ReaderModelDTO readerDTO = new ReaderModelDTO();
            BeanUtils.copyProperties(readerModel, readerDTO);
            return readerDTO;
        }
    return null;
    }

    public Boolean deleteReader(ReaderModelIU reader){
        if(readerRepository.existsById(reader.getId())){
            readerRepository.deleteById(reader.getId());
            return true;
        }
        return false;
    }

}
