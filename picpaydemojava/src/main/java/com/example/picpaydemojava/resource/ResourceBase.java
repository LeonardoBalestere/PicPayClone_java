package com.example.picpaydemojava.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class ResourceBase<T> {
	
	protected ResponseEntity<T> answerCreatedItem(T object) {
		return ResponseEntity.status(HttpStatus.CREATED).body(object);
	}

	protected ResponseEntity<T> answerCreatedItemWithURI(T object, UriComponentsBuilder uriBuilder, String path,
			String code) {
		URI uri = uriBuilder.path(path).buildAndExpand(code).toUri();
		return ResponseEntity.created(uri).body(object);
	}

	protected ResponseEntity<T> answerNotCreatedItem() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	protected ResponseEntity<T> answerSuccessfully() {
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	protected ResponseEntity<T> answerSuccessfullyWithItem(T object) {
		return ResponseEntity.status(HttpStatus.OK).body(object);
	}

	protected ResponseEntity<List<T>> answerEmptyList() {
		List<T> emptyList= new ArrayList<>();
		return ResponseEntity.status(HttpStatus.OK).body(emptyList);
	}

	protected ResponseEntity<List<T>> answerItemList(List<T> item) {
		return ResponseEntity.status(HttpStatus.OK).body(item);
	}

	protected ResponseEntity<T> answerUnsuccessfullRequisition() {
		return ResponseEntity.badRequest().build();
	}

	protected ResponseEntity<Page<T>> answerPagedListItem(Page<T> transactions) {
		return ResponseEntity.status(HttpStatus.OK).body(transactions);
	}
}
 