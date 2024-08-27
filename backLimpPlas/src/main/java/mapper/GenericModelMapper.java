package mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class GenericModelMapper<T,D> {
	
	private final ModelMapper modelMapper;
	private final Class<D> destinationClass;
	
	public GenericModelMapper(Class<D> destinationClass){
    
		 this.modelMapper = new ModelMapper();
		 this.destinationClass = destinationClass;
	}
	
	public D map(T source) {
		
		return modelMapper.map(source, destinationClass);
	}
	
	public List<D> mapList(List<T> sourceList){
		
		return sourceList.stream().map(source -> modelMapper.map(source, destinationClass)).collect(Collectors.toList());
	}
	 
}
