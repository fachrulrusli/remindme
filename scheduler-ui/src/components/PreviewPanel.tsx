export default function PreviewPanel() {
  return (
    <div className="w-80 bg-black border-l border-gray-800 p-3 text-xs">
      <div className="bg-[#111] rounded-lg p-3 h-full flex flex-col">
        <h3 className="text-sm mb-2">Preview WhatsApp</h3>

        <div className="flex-1 space-y-2 overflow-auto">
          <Bubble text="Berita AI hari ini..." />
          <Bubble text="OpenAI update terbaru..." />
        </div>

        <input
          placeholder="Ketik pesan..."
          className="mt-2 bg-[#222] rounded px-2 py-1 text-xs outline-none"
        />
      </div>
    </div>
  );
}

function Bubble({ text }: { text: string }) {
  return (
    <div className="bg-[#222] p-2 rounded text-xs">
      {text}
    </div>
  );
}