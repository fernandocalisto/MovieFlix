package com.fernandocalisto.MovieFlix.controller;

import com.fernandocalisto.MovieFlix.controller.request.StreamingRequest;
import com.fernandocalisto.MovieFlix.controller.response.StreamingResponse;
import com.fernandocalisto.MovieFlix.entity.Streaming;
import com.fernandocalisto.MovieFlix.mapper.StreamingMapper;
import com.fernandocalisto.MovieFlix.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("movieflix/streaming")
public class StreamingController {

    private final StreamingService service;

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> getAllStreamings() {
        List<Streaming> category = service.findAll();
        List<StreamingResponse> list = category.stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping()
    public ResponseEntity<StreamingResponse> saveStreaming(@RequestBody StreamingRequest request) {
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming savedStreaming = service.saveStreaming(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedStreaming));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getStreamingByID(@PathVariable Long id) {
        return service.findStreamingById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStreamingById(@PathVariable Long id) {
        service.deleteStreamingById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
