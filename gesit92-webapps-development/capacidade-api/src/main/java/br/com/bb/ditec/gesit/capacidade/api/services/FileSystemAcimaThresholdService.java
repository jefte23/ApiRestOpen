package br.com.bb.ditec.gesit.capacidade.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.ditec.gesit.capacidade.api.dto.Parametros;
import br.com.bb.ditec.gesit.capacidade.api.entities.resultMapping.FilesystemAcimaThreshold;
import br.com.bb.ditec.gesit.capacidade.api.repositories.FileSystemAcimaThresholdRepository;

@Service
public class FileSystemAcimaThresholdService {

	@Autowired
	private  FileSystemAcimaThresholdRepository fileSystemAcimaThresholdRepository;
    

	public FileSystemAcimaThresholdService( ) {}


	public List<FilesystemAcimaThreshold> buscarFileSystemComConsumoAcimaDoThresholdNosUltimos30Dias(  Parametros param ) {
		return fileSystemAcimaThresholdRepository.buscarFileSystemComConsumoAcimaDoThresholdNosUltimos30Dias(param);
	}
	
	

}
