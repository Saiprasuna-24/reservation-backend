//package com.reservation.management.controllers;
//
//import java.io.IOException;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.multipart.MaxUploadSizeExceededException;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.reservation.management.entity.ReservationDocs;
//import com.reservation.management.entity.Reservations;
//import com.reservation.management.payload.FileUploadUtil;
//import com.reservation.management.payload.Response;
//
//@RestControllerAdvice
//@RestController
//@RequestMapping("/api/reservations/")
//public class FileUploadController {
	
//	with random string
//not this

//	@PostMapping("/uploadFile")
//	 public ResponseEntity<ReservationDocs> uploadFile(@RequestParam("file") MultipartFile multipartFile ) throws IOException{
//		
//		String fileName=StringUtils.cleanPath(multipartFile.getOriginalFilename());
//		 long size=multipartFile.getSize();
//		// int reservationid=reservation.getId();
//		 
//		 String fileCode = FileUploadUtil.saveFile(fileName, multipartFile);
//		 FileUploadUtil.saveFile(fileName, multipartFile);
//		 ReservationDocs docs =new ReservationDocs();
//		 Response response =new Response();
//		 response.setFileName(fileName);
//		 response.setSize(size);
//		 response.setFileDownloadUri("/downloadFile/" + fileCode);
//		 docs.setDocumentUrl("/downloadFile/" + fileCode);
//		 //docs.setReservationId(reservationid);
//		 
//		 return new  ResponseEntity<>(docs,HttpStatus.OK);
//		
//	}
//	
//	@ExceptionHandler(MaxUploadSizeExceededException.class)
//	public ResponseEntity<String> DocumentSizeLimitExceededExcption(RedirectAttributes ra) {
//		//return ra.addFlashAttribute("error","you could not upload file bigger than X MB");
//		return new ResponseEntity<String>("you could not enter file bigger than 1 MB",HttpStatus.BAD_REQUEST);
//	}
//	
//}
	
	
	
	
	
	
//	 @Autowired
//	    private DatabaseService databaseService ;
//
//	public FileUploadController(DatabaseService databaseService) {
//		
//		this.databaseService = databaseService;
//	}
//	 
//	@PostMapping("/upload")
//	public Response uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
//		DatabaseFile databaseFile=null;
//		String fileDownloadUri="";
//		 databaseFile=databaseService.saveAttachment(file);
//		 fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath()
//				     .path("/download")
//				     .path(databaseFile.getId())
//				     .toUriString();
//		
//		 return new Response(databaseFile.getFileName(),fileDownloadUri,file.getContentType(),file.getSize());
//	}
//	
//	 @GetMapping("/download/{fileId}")
//	 public ResponseEntity<Resource> downLoadFile(@PathVariable String fileId) throws Exception{
//		 DatabaseFile  databaseFile =null;
//		 databaseFile=databaseService.getDatabaseFile(fileId);
//		 return ResponseEntity.ok()
//				 .contentType(MediaType.parseMediaType(databaseFile.getFileType()))
//				 .header(HttpHeaders.CONTENT_DISPOSITION,
//						 "databaseFile; fileName=\"" +  databaseFile.getFileName()
//						 +"\"")
//				 .body(new ByteArrayResource( databaseFile.getData()));
//		 
//	 }

	 
//ramesh ...



//	    @PostMapping("/uploadFile")
//	    public Response uploadFile(@RequestParam("file") MultipartFile file) {
//	    	DatabaseFile fileName = fileStorageService.storeFile(file);
//
//	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//	                .path("/downloadFile/")
//	                .path(fileName.getFileName())
//	                
//	                .toUriString();
//
//	        return new Response(fileName.getFileName(), fileDownloadUri,
//	                file.getContentType(), file.getSize());
//	    }

//	    @PostMapping("/uploadMultipleFiles")
//	    public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//	        return Arrays.asList(files)
//	                .stream()
//	                .map(file -> uploadFile(file))
//	                .collect(Collectors.toList());
//	    }


