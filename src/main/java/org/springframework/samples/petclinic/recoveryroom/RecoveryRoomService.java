package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.samples.petclinic.recoveryroom.RecoveryRoomService;
import org.springframework.beans.factory.annotation.Autowired;



public class RecoveryRoomService {
	private RecoveryRoomRepository recoveryRoomRepository;
	@Autowired
	public RecoveryRoomService(RecoveryRoomRepository recoveryRoomRepository) {
		this.recoveryRoomRepository=recoveryRoomRepository;
	}

    public List<RecoveryRoom> getAll(){
        return recoveryRoomRepository.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return recoveryRoomRepository.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return recoveryRoomRepository.getRecoveryRoomType(typeName);
    }

    public RecoveryRoom save(RecoveryRoom p) throws DuplicatedRoomNameException {
    	return recoveryRoomRepository.save(p);       
    }
    public List<RecoveryRoomType> findAllRecoveryRoomTypes(){
		return recoveryRoomRepository.findAllRecoveryRoomTypes();
    }

    
}
