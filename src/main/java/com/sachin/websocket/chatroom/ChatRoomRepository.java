package com.sachin.websocket.chatroom;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);

    @Query("{'senderId': ?0, 'recipientId': ?1}")
    Optional<ChatRoom> findByCustomQuery(String senderId, String recipientId);
}