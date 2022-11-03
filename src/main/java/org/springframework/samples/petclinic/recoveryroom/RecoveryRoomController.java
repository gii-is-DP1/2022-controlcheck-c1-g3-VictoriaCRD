package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class RecoveryRoomController {
	
private RecoveryRoomService recoveryRoomService;
	
	@Autowired
	public RecoveryRoomController(RecoveryRoomService recoveryRoomService) {
		this.recoveryRoomService=recoveryRoomService;
	}
	
	@InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
	
	@ModelAttribute("types")
    public List<RecoveryRoomType> populatePetTypes() {
        return this.recoveryRoomService.findAllRecoveryRoomTypes();
    }

	@GetMapping(value = "/recoveryroom/create")
	public String initCreationForm(Map<String, Object> model) {
		RecoveryRoom recoveryroom = new RecoveryRoom();
		model.put("recoveryroom",recoveryroom);
		return "recoveryrooms/createOrUpdateProductForm";
	}
	
	
	@PostMapping(value = "/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom recoveryroom, BindingResult result, ModelMap model)throws DuplicatedRoomNameException {
		if (result.hasErrors()) {
			return "recoveryrooms/createOrUpdateProductForm";
		}
		else {
			this.recoveryRoomService.save(recoveryroom);
			return "welcome";
		}
	}
    
}
