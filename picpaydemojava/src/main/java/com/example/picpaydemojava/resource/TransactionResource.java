package com.example.picpaydemojava.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.picpaydemojava.dto.TransactionDTO;
import com.example.picpaydemojava.service.ITransactionService;

@RestController
@RequestMapping("/tansactions")
public class TransactionResource extends ResourceBase<TransactionDTO>{

	@Autowired
	private ITransactionService transactionService;
	
	@PostMapping
	public ResponseEntity<TransactionDTO> save(@RequestBody @Valid TransactionDTO transactionDTO,
			UriComponentsBuilder uriBuilder){
		TransactionDTO transactionReturnDTO = transactionService.process(transactionDTO);
		return answerCreatedItemWithURI(transactionReturnDTO,
				uriBuilder,
				"/transaction/{code}", 
				transactionReturnDTO.getCode());
	}
	
	@GetMapping
	public ResponseEntity<Page<TransactionDTO>> list(@PageableDefault( page = 0, size = 20) Pageable paging,
			@RequestParam String login){
		Page<TransactionDTO> transactions = transactionService.list(paging, login);
		return answerPagedListItem(transactions);
	}
}
