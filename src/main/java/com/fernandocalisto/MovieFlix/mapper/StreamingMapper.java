package com.fernandocalisto.MovieFlix.mapper;

import com.fernandocalisto.MovieFlix.controller.request.StreamingRequest;
import com.fernandocalisto.MovieFlix.controller.response.StreamingResponse;
import com.fernandocalisto.MovieFlix.entity.Streaming;

public class StreamingMapper {

    public static Streaming toStreaming (StreamingRequest request){
        return Streaming.builder()
                .name(request.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse (Streaming streaming) {
        return StreamingResponse.builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }

}
