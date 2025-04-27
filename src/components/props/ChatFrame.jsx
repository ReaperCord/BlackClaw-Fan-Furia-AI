import './ChatFrame.css'
import './ChatBubbleAi.css'
import './ChatBubbleuser.css'

import ChatBubbleUser from './ChatBubbleUser'
import ChatBubbleAi from './ChatBubbleAi'

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faArrowUp } from '@fortawesome/free-solid-svg-icons';

function ChatFrame() {

    return(
        <div className='frame-body'>
            <div className='conversation'>
                <ChatBubbleUser user={"Fala Pantera! Quando a Furia joga?"} className='user' />
                <ChatBubbleAi ai={"Bom dia Furioso! Nossas próximas partidas serão em pela PGL Astana 2025 que começa em 10/05/2024! Os confrontos ainda não tem data definida mais pra frente posso te trazer todos os detalhes, conforme a organização do evento for liberando os confrontos e os horários!"} className='ai' />
                <ChatBubbleUser user={"Fala Pantera! Quando a Furia joga?"} className='user' />
                <ChatBubbleAi ai={"Bom dia Furioso! Nossas próximas partidas serão em pela PGL Astana 2025 que começa em 10/05/2024! Os confrontos ainda não tem data definida mais pra frente posso te trazer todos os detalhes, conforme a organização do evento for liberando os confrontos e os horários!"} className='ai' />
                <ChatBubbleUser user={"Fala Pantera! Quando a Furia joga?"} className='user' />
                <ChatBubbleAi ai={"Bom dia Furioso! Nossas próximas partidas serão em pela PGL Astana 2025 que começa em 10/05/2024! Os confrontos ainda não tem data definida mais pra frente posso te trazer todos os detalhes, conforme a organização do evento for liberando os confrontos e os horários!"} className='ai' />
                <ChatBubbleUser user={"Fala Pantera! Quando a Furia joga?"} className='user' />
                <ChatBubbleAi ai={"Bom dia Furioso! Nossas próximas partidas serão em pela PGL Astana 2025 que começa em 10/05/2024! Os confrontos ainda não tem data definida mais pra frente posso te trazer todos os detalhes, conforme a organização do evento for liberando os confrontos e os horários!"} className='ai' />
                <ChatBubbleUser user={"Fala Pantera! Quando a Furia joga?"} className='user' />
                <ChatBubbleAi ai={"Bom dia Furioso! Nossas próximas partidas serão em pela PGL Astana 2025 que começa em 10/05/2024! Os confrontos ainda não tem data definida mais pra frente posso te trazer todos os detalhes, conforme a organização do evento for liberando os confrontos e os horários!"} className='ai' />
                <ChatBubbleUser user={"Fala Pantera! Quando a Furia joga?"} className='user' />
                <ChatBubbleAi ai={"Bom dia Furioso! Nossas próximas partidas serão em pela PGL Astana 2025 que começa em 10/05/2024! Os confrontos ainda não tem data definida mais pra frente posso te trazer todos os detalhes, conforme a organização do evento for liberando os confrontos e os horários!"} className='ai' />
                
            </div>
            
            <div className='ask-bar'>
                <textarea className='text-area' placeholder='Olá! Como posso te ajudar hoje?'></textarea>
                <button className='button-send'>
                    <p><FontAwesomeIcon icon={faArrowUp} /></p>
                </button>
            </div>
        </div>
    )
}

export default ChatFrame