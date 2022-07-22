package ru.alxstn.ContractsClient.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import ru.alxstn.ContractsClient.exception.OutOfDataException;
import ru.alxstn.ContractsClient.model.Contract;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public class ContractDeserializer {

    public static Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateAdapter().nullSafe())
            .create();

    private static final class LocalDateAdapter extends TypeAdapter<LocalDateTime> {
        @Override
        public void write(final JsonWriter jsonWriter, final LocalDateTime localDate ) throws IOException {
            jsonWriter.value(localDate.toString());
        }

        @Override
        public LocalDateTime read( final JsonReader jsonReader ) throws IOException {
            return LocalDateTime.parse(jsonReader.nextString());
        }
    }

    public static Contract[] readContractArray(String jsonString) throws OutOfDataException {
        try {
            Type contractListType = new TypeToken<List<Contract>>(){}.getType();
            Collection<Contract> contracts = gson.fromJson(jsonString, contractListType);
            if (contracts.size() != 0)
                return contracts.toArray(new Contract[]{});
            else throw new OutOfDataException();
        } catch (IllegalStateException | JsonSyntaxException e) {
            e.printStackTrace();
        }
        return new Contract[]{};
    }

    public static Contract readContract(String jsonString) throws OutOfDataException {
        try {
            Type contractType = new TypeToken<Contract>(){}.getType();
            return gson.fromJson(jsonString, contractType);
        } catch (IllegalStateException | JsonSyntaxException e) {
            e.printStackTrace();
        }
        return new Contract();
    }
}


