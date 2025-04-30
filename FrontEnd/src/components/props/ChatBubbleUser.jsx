import React from 'react'

const ChatBubbleUser = (mensagem) => {
    return (
        <div className='bubble-text-user'>
            <p>{mensagem.user}</p>
        </div>
    )
}

export default ChatBubbleUser